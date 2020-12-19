/*
 * Copyright 2013-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.awspring.cloud.messaging.endpoint.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Spring Web MVC request mapping that supports Amazon SNS HTTP endpoints using the Spring
 * Controller model. This annotation configures a method to receive notification messages
 * on the method. A notification method can have two parameters annotation by the
 * {@link io.awspring.cloud.messaging.config.annotation.NotificationMessage} annotation to
 * receive the payload and and a
 * {@link io.awspring.cloud.messaging.config.annotation.NotificationSubject} annotation to
 * receive the subject of a notification.
 *
 * A notification controller will be mapped to a particular url inside the application
 * context. The mapped url must be configured inside the Amazon Web Service platform as a
 * subscription. Before receiving any notification itself a controller must confirm the
 * subscription. Controllers will use a
 * {@link io.awspring.cloud.messaging.endpoint.annotation.NotificationSubscriptionMapping}
 * annotated method to confirm the subscription.
 *
 * The mapping of the controller to a URL has to be done using a
 * {@link org.springframework.web.bind.annotation.RequestMapping} annotation. Typically
 * one controller class will contain all the methods used to confirm a subscription,
 * receive notifications and receive the unsubscribe message.
 *
 * <b>Note:</b> Currently this annotation does not allow an explicit mapping of controller
 * methods to URLs. Therefore this annotation can only be used in one controller class
 * that has an class level @RequestMapping annotation.
 *
 * @author Agim Emruli
 */
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping(headers = "x-amz-sns-message-type=Notification", method = RequestMethod.POST)
@ResponseStatus(HttpStatus.NO_CONTENT)
public @interface NotificationMessageMapping {

}
