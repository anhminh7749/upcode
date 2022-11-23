package com.watch.shopwatchonline.Service.ServiceImpl;

import java.util.Map;
import java.util.Objects;

import com.watch.shopwatchonline.Domain.MailRequest;
import com.watch.shopwatchonline.Service.MailService;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class MailServiceImpl implements MailService {

  private final JavaMailSender emailSender;

  @Override
  // Tạo để ở 1 thread khác.
  public void send(MailRequest request) {
    try {
      SimpleMailMessage message = new SimpleMailMessage();
      message.setTo(request.getTo());
      message.setSubject(this.mapParamsIntoMail(request.getParams(), request.getSubject()));
      message.setText(this.mapParamsIntoMail(request.getParams(), request.getBody()));

      this.emailSender.send(message);
      log.info("Send email to {} success", request.getTo());
    } catch (Exception ex) {
      log.error("Send email error: ", ex);
    }
  }

  private String mapParamsIntoMail(Map<String, String> params, String template) {
    if (Objects.isNull(params)) {
      return template;
    }
    for (Map.Entry<String, String> param : params.entrySet()) {
      var key = param.getKey(); // Example key in DB: [({$key})]
      var value = param.getValue();
      template = template.replace(String.format("[({$%s})]", key), value);
    }
    return template;
  }
}
