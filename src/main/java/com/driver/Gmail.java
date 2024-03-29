package com.driver;

import java.util.ArrayList;
import java.util.Date;
class Mails{
    private Date date;
    private String sender;
    private String message;
    Mails(Date date,String sender,String message){
        this.date=date;
        this.sender=sender;
        this.message=message;
    }
        public String getSender(){
            return sender;
        }
        public Date getDate() {
            return date;
        }

        public String getMessage() {
            return message;
        }
}
public class Gmail extends Email {

    int inboxCapacity; //maximum number of mails inbox can store
    ArrayList<Mails> inbox;//=new ArrayList<>();
    ArrayList<Mails> trash;//new ArrayList<>();
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity = inboxCapacity;
        this.inbox = new ArrayList<>();
        this.trash = new ArrayList<>();
    }

    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.
        inbox.add(new Mails(date,sender,message));
        if(inbox.size()>inboxCapacity){
            trash.add(inbox.get(0));
            inbox.remove(0);
        }
    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
        for (int i = 0; i < inbox.size(); i++) {
            if (inbox.get(i).getMessage().equals(message)) {
                trash.add(inbox.get(i));
                inbox.remove(i);
                break; // Once found and moved to trash, exit the loop
            }
        }
    }

    public String findLatestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox
        if(inbox.size()==0)
            return null;
        return inbox.get(inbox.size()-1).getMessage();
    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox
        if(inbox.size()==0)
            return null;
        return inbox.get(0).getMessage();
    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
         int ans = 0;
        for (int i = 0; i < inbox.size(); i++) {
            if (inbox.get(i).getDate().after(start) && inbox.get(i).getDate().before(end)) {
                ans++;
            }
        }
        return ans;
    }

    public int getInboxSize(){
        // Return number of mails in inbox
        return inbox.size();
    }

    public int getTrashSize(){
        // Return number of mails in Trash
        return trash.size();
    }

    public void emptyTrash(){
        // clear all mails in the trash
        trash.clear();
    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
        return inboxCapacity-inbox.size();
    }
}
