package com.example.demo.entity;

import java.util.List;
import java.util.Map;

/**
 * @author sunxian
 * @version 2022-07-26 10:02
 */
public class RequestDto {
    private request request;



    public class request{

       private Map<String, List<Object>> body;
        private head head;
        public Map<String, List<Object>> getBody() {
            return body;
        }

        public void setBody(Map<String, List<Object>> body) {
            this.body = body;
        }

        public request(Map<String, List<Object>> body) {
            this.body = body;
        }

        public RequestDto.head getHead() {
            return head;
        }

        public void setHead(RequestDto.head head) {
            this.head = head;
        }
    }

    public class head{
        private  String funcode;
        private String userid;
        private String reqid;

        public String getFuncode() {
            return funcode;
        }

        public void setFuncode(String funcode) {
            this.funcode = funcode;
        }

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public head(String funcode, String userid, String reqid) {
            this.funcode = funcode;
            this.userid = userid;
            this.reqid = reqid;
        }
    }

    public RequestDto.request getRequest() {
        return request;
    }

    public void setRequest(RequestDto.request request) {
        this.request = request;
    }




}
