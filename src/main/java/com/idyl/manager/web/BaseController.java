package com.idyl.manager.web;


import com.idyl.manager.service.account.ShiroDbRealmService;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.beans.PropertyEditorSupport;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Controller 基类
 */
public class BaseController implements ServletContextAware {

    private static Logger logger = Logger.getLogger(BaseController.class);


    public static final String DATE_FORMAT = "yyyy-MM-dd";// DateFormat
	public static final String COMMON_FAIL_PAGE = "fail";
	public static final String COMMON_FAIL_ALERT_KEY = "fail_key";
    public static final String MESSAGE = "message";
    public static final Map<String,List<Map<String,Object>>> shdmap=new HashMap<String, List<Map<String,Object>>>();
    public static final Map<String,String> mapTableName=new HashMap<String, String>();
    private MessageSourceAccessor messages;
    private ServletContext servletContext;

    @Autowired
    public void setMessages(MessageSource messageSource) {

        messages = new MessageSourceAccessor(messageSource);
    }

    public String getText(String msgKey) {
        return messages.getMessage(msgKey, Locale.CHINA);
    }


    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Integer.class, null,
                new CustomNumberEditor(Integer.class, null, true));
        binder.registerCustomEditor(Long.class, null,
                new CustomNumberEditor(Long.class, null, true));
        binder.registerCustomEditor(byte[].class,
                new ByteArrayMultipartFileEditor());

        
        binder.registerCustomEditor(Date.class,new PropertyEditorSupport() {
            public void setAsText(String value) {
                try {
                    setValue(new SimpleDateFormat(DATE_FORMAT).parse(value));
                } catch(Exception e) {
                    setValue(null);
                }
            }

            public String getAsText() {
                return new SimpleDateFormat(DATE_FORMAT).format((Date) getValue());
            }

        });

        binder.registerCustomEditor(Timestamp.class,new PropertyEditorSupport() {
            public void setAsText(String value) {
                try {
                    setValue(new SimpleDateFormat(DATE_FORMAT).parse(value));
                } catch(ParseException e) {
                    setValue(null);
                }
            }

            public String getAsText() {
                return new SimpleDateFormat(DATE_FORMAT).format((Date) getValue());
            }

        });


    }



    /**
     * 异常控制，这便是异常细节可控，将来可用于支持国际化（异常信息国际化）
     * */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView handleException(Exception exception ,HttpServletRequest request) {
        ModelAndView returnValue = new ModelAndView();
        returnValue.addObject(COMMON_FAIL_ALERT_KEY, "系统处理异常"+exception.getMessage());
        logger.error(exception.getMessage(), exception);
        return returnValue;
    }


    /**
     * 创建TOKEN
     * liuzhaochun add
     * @param request
     */
    public synchronized void saveToken(HttpServletRequest request,HttpServletResponse response) {
//        setResponseNoCache(response); //
        HttpSession session = request.getSession();
        String token = generateToken(request);
        if (token != null) {
            session.setAttribute("TRANSACTION_TOKEN_KEY", token);
        }

    }

    public synchronized void saveToken(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String token = generateToken(request);
        if (token != null) {
            session.setAttribute("TRANSACTION_TOKEN_KEY", token);
        }

    }


    /**
     * 验证TOKEN
     * @param request
     * @return
     */
    public synchronized  boolean isTokenValid(HttpServletRequest request) {
        // Retrieve the current session for this request
        HttpSession session = request.getSession(false);

        if (session == null) {
            return false;
        }

        // Retrieve the transaction token from this session, and
        // reset it if requested
        String saved =
                (String) session.getAttribute("TRANSACTION_TOKEN_KEY");

        if (saved == null) {
            return false;
        }


        // Retrieve the transaction token included in this request
        String token = request.getParameter("TRANSACTION_TOKEN_KEY");

        if (token == null) {
            return false;
        }
        session.removeAttribute("TRANSACTION_TOKEN_KEY");
        return saved.equals(token);
    }

    private synchronized String generateToken(HttpServletRequest request) {
        HttpSession session = request.getSession();
        try {
            byte id[] = session.getId().getBytes();
            byte now[] =
                    new Long(System.currentTimeMillis()).toString().getBytes();
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(id);
            md.update(now);
            return (toHex(md.digest()));
        } catch (IllegalStateException e) {
            return (null);
        } catch (NoSuchAlgorithmException e) {
            return (null);
        }
    }

    private static String toHex(byte[] buffer) {
        StringBuffer sb = new StringBuffer(buffer.length * 2);

        for (int i = 0; i < buffer.length; i++) {
            sb.append(Character.forDigit((buffer[i] & 0xf0) >> 4, 16));
            sb.append(Character.forDigit(buffer[i] & 0x0f, 16));
        }

        return sb.toString();
    }


    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;

    }
    protected ServletContext getServletContext() {
        return servletContext;
    }

    // 获取真实IP的方法().                                jsp
    private String getIpAddr(HttpServletRequest request) throws Exception {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        return ip;
    }



}
