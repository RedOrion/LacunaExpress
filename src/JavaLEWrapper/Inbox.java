package JavaLEWrapper;

import java.io.IOException;

public class Inbox extends LESuperClass {
    public static final String url = "inbox";

    public static String ViewInbox(String sessionID, String tag ){
        return "{\"jsonrpc\":2,\"id\":1,\"method\":\"view_inbox\",\"params\":[\""+sessionID+"\",{\"tags\":[\""+tag+"\"],\"page_number\":1}]}";
    }
    public static String ViewInbox(String sessionID, String tag, int pageNumber ){
        return "{\"jsonrpc\":2,\"id\":1,\"method\":\"view_inbox\",\"params\":[\""+sessionID+"\",{\"tags\":[\""+tag+"\"],\"page_number\":"+pageNumber+"}]}";
    }
    String ReadMessage(int RequestID, String sessionID, String MessageID){
    	return Request("read_message", sessionID, String.valueOf(RequestID), MessageID);
        /*StartOfObject(RequestID, "read_message");
        String i = "nothing";
        try {
            writer.value(sessionID);
            writer.value(MessageID);
            writer.endArray();
            writer.endObject();
            writer.close();
            i = gson.toJson(writer);
            System.out.println(i);
            i = CleanJsonObject(i);

        } catch (IOException e) {
            System.out.println("Exception in read_message");
            i = "request build failed";
            e.printStackTrace();
        }
        return i; */
    }
    String SendMessage(String sessionID, String recipients, String subject, String body){
        StartOfObject(1, "send_message");
        String i = "0";
        try{
            writer.value(sessionID);
            writer.value(recipients);
            writer.value(subject);
            writer.value(body);
            writer.endArray();
            writer.endObject();
            writer.close();
            i = gson.toJson(writer);
            i = CleanJsonObject(i);
        }catch(IOException e){
            System.out.println("ioexception");
        }catch(NullPointerException e){
            System.out.println("null pointer exception");
        }finally{
        }
        return i;
    }
    //{"id":9,"method":"send_message","jsonrpc":"2.0","params":["7190e43d-8722-4e5a-ad72-3aacdacfe0df","Norway,icydee","Account List","Could a method be added to the api that returns a list of all current valid accounts for mailing purposes.  I was checking what the current web client does and it spends a lot of rpcs looking up each individual account.\n\nI thought it might be nice to have a single request which just returns a list of all current account names that I could use to compare to instead.\n\n-=Jazz=-",null]}
/*enum MessageTags{  //will be leaving this as an option to use in the future, but currently just passing a string directly to the methods instead
		Tutorial, Correspondence, Medal, Intelligence, Alert, Attack, Colonization, Complaint, Excavator, Mission, Parliament, Probe, Spies, Trade, Fissure;
	} */

}
/*
Inbox Methods
view_inbox ( session_id, [ options ] )
session_id
options
page_number
tags
view_archived ( session_id, [ options ])
view_trashed ( session_id, [ options ])
view_sent ( session_id, [ options ] )
read_message ( session_id, message_id )
session_id
message_id
archive_messages ( session_id, message_ids )
session_id
message_ids
trash_messages ( session_id, message_ids )
session_id
message_ids
send_message ( session_id, recipients, subject, body, [ options ] )
session_id
recipients
subject
body
options
in_reply_to
forward
*/