package service;

import java.io.IOException;


import com.sendgrid.*;

public class EnviarEmail {
	private String pTo;
	private String pSubject;
	private String pContent;
	private String pFrom = "sistema@acessofacil.io";
	
	public EnviarEmail(String to, String subject, String content) {
		this.pTo = to;
		this.pSubject = subject;
		this.pContent = content;
	}
	
	public void send(){
		Email from = new Email(this.pFrom);
	    String subject = this.pSubject;
	    Email to = new Email(this.pTo);
	    Content content = new Content("text/plain", this.pContent);
	    Mail mail = new Mail(from, subject, to, content);
	    SendGrid sg = new SendGrid("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");
	    Request request = new Request();
	    try {
	      request.setMethod(Method.POST);
	      request.setEndpoint("mail/send");
	      request.setBody(mail.build());
	      Response response = sg.api(request);
	      System.out.println(response.getStatusCode());
	    } catch (IOException ex) {
	      try {
			throw ex;
		} catch (IOException e) {
			e.printStackTrace();
		}
	    }
	}
}
