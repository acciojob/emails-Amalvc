package com.driver;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Gmail extends Email {

    int inboxCapacity; //maximum number of mails inbox can store
    ArrayList<mail> inb=new ArrayList<mail>();
    ArrayList<mail> tra=new ArrayList<mail>();

    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    public Gmail(String emailId, int inboxCapacity) {
            super(emailId);
            this.inboxCapacity=inboxCapacity;

    }

    class mail {
        Date date;
        String sender;
        String message;

        public mail(Date date, String sender, String message) {
            this.date = date;
            this.sender = sender;
            this.message = message;
        }

        public String getMessage() {
            return this.message;
        }
    }

    public void receiveMail(Date date, String sender, String message){
        int limit=getInboxSize();
        int limit2=getInboxCapacity();
        if(limit<limit2){
            inb.add(new mail(date,sender,message));
        }
        else{
            mail mm=inb.get(0);
            inb.remove(0);
            tra.add(mm);
            inb.add(new mail(date,sender,message));
        }
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.

    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
        Iterator<mail> it = inb.iterator();
        while (it.hasNext()) {
            mail o = it.next();
            if(o.getMessage().equals(message))
            {
                tra.add(o);
                it.remove();
                break;
            }
        }


    }



    public String findLatestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox
        int m=getInboxSize();
        if(getInboxSize()==0){
            return null;
        }
        else{
            String ans= inb.get(m-1).message;

            return ans;

        }

    }

    public String findOldestMessage(){
        if(getInboxSize()==0){
            return null;
        }
        else{
            String ans= inb.get(0).message;

            return ans;

        }
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox

    }


    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date


        Iterator<mail> it = inb.iterator();
        int count=0;
        while (it.hasNext()) {
            mail obj=it.next();

            if(obj.date.getTime()>=start.getTime() && obj.date.getTime()<=end.getTime())
            {
                count++;
            }

        }
        return count;

    }

    public int getInboxSize(){
        // Return number of mails in inbox
        return inb.size();

    }

    public int getTrashSize(){
        // Return number of mails in Trash
        return tra.size();
    }

    public void emptyTrash(){
        // clear all mails in the trash
      tra.clear();

    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
        return this.inboxCapacity;
    }
}






