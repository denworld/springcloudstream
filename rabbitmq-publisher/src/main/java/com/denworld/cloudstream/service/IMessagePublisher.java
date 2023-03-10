package com.denworld.cloudstream.service;

/**
 * @author ywang Email:denworld@gmail.com
 * @since 2023/03/07 16:30
 */
public interface IMessagePublisher {
    void publish(String message);
}