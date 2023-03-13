package com.springbootemail.application.model;

import com.sun.mail.imap.IMAPMessage;

import javax.mail.*;
import java.io.*;

public class Retrive {
    private String saveDirectory;
    private String userName;
    private String password;
    private String[] Email_list={};
    public Retrive() {
    }

    public String[] getEmail_list() {
        return Email_list;
    }

    public void setEmail_list(String[] email_list) {
        Email_list = email_list;
    }

    public Retrive(String saveDirectory, String userName, String password) {
        this.saveDirectory = saveDirectory;
        this.userName = userName;
        this.password = password;
    }

    public String getSaveDirectory() {
        return saveDirectory;
    }

    public void setSaveDirectory(String saveDirectory) {
        this.saveDirectory = saveDirectory;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Retrive{" +
                "saveDirectory='" + saveDirectory + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    public String textContent(Message message) throws MessagingException, IOException {

        Object content = message.getContent();

        String content_text = null;
        if (content instanceof String) {
            content_text = (String) content;
        } else {
            content_text = "no text message";
        }
        return content_text;
    }

    public void processMessageBody(Message message)
    {
        try {

            Object content = message.getContent();

            // check for string
            // then check for multipart

             if (content instanceof String)
            {
                System.out.println(content); }

            else if (content instanceof Multipart)
            { Multipart multiPart = (Multipart) content;
                processMultiPart(multiPart); }
            if (content instanceof InputStream )
            { InputStream inStream = (InputStream) content;
                int ch;
                while ((ch = inStream.read()) != -1)
                { System.out.write(ch); }
            }

        }
        catch (IOException e)
        { e.printStackTrace();
        }
        catch (MessagingException e)
        { e.printStackTrace(); }
    } public void processMultiPart(Multipart content)
    {
         Retrive retrive;
        try
        { for (int i = 0; i < content.getCount(); i++)
        {
            BodyPart bodyPart = content.getBodyPart(i);
            Object o;
            o = bodyPart.getContent();

            if (o instanceof String)
            { System.out.println("Text = " + o);
            } else if (null != bodyPart.getDisposition() && bodyPart.getDisposition().equalsIgnoreCase( Part.ATTACHMENT))
            { String fileName = bodyPart.getFileName();
                System.out.println("fileName = " + fileName);
                InputStream inStream = bodyPart.getInputStream();
                FileOutputStream outStream = new FileOutputStream(new File( saveDirectory  + fileName));
                byte[] tempBuffer = new byte[4096];// 4 KB
                int numRead;
                while ((numRead = inStream.read(tempBuffer)) != -1)
                {
                    outStream.write(tempBuffer);
                }
                inStream.close();
                outStream.close(); }
        }
        } catch (FileNotFoundException ex){
        ex.printStackTrace();
        System.out.println("could not determine file location");
    } catch (IOException e) {
            e.printStackTrace(); } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
