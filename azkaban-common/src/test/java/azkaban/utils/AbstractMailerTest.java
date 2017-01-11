/*
 * Copyright 2014 LinkedIn Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package azkaban.utils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AbstractMailerTest {

    /**
     * test emailMessage properties
     */
    @Test
    public void testCreateEmailMessage(){

        List<String> senderList = new ArrayList<String>();
        senderList.add("sender@xxx.com");
        EmailMessage emailMessage = null;



        //for Custom
        Props props = new Props();
        props.put("mail.port",445);
        props.put("mail.user","somebody");
        props.put("mail.password","pwd");
        props.put("mail.sender","somebody@xxx.com");
        props.put("server.port","114");
        props.put("server.useSSL","false");
        AbstractMailer mailer = new AbstractMailer(props);
        emailMessage = mailer.createEmailMessage("subject","text/html",senderList);

        assert emailMessage.getMailPort()==445;


        //for default
        Props defaultProps = new Props();
        defaultProps.put("mail.user","somebody");
        defaultProps.put("mail.password","pwd");
        defaultProps.put("mail.sender","somebody@xxx.com");
        defaultProps.put("server.port","114");
        defaultProps.put("server.useSSL","false");
        mailer = new AbstractMailer(defaultProps);
        emailMessage = mailer.createEmailMessage("subject","text/html",senderList);

        assert emailMessage.getMailPort()==25;

    }

}
