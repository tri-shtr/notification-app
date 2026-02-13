package com.example.notificationapp.service;

import com.example.notificationapp.model.NotificationChannel;
import com.example.notificationapp.notification.EmailNotification;
import com.example.notificationapp.notification.Notification;
import com.example.notificationapp.notification.SlackNotification;
import com.example.notificationapp.notification.SmsNotification;

/**
 * 通知チャネルに応じた実装を生成するファクトリ。
 * ステートレスなためスレッドセーフです。
 */
public class NotificationFactory {
    private final NotificationHistoryRepository repository;

    /**
     * ファクトリを生成します。
     *
     * @param repository 履歴リポジトリ
     */
    public NotificationFactory(NotificationHistoryRepository repository) {
        this.repository = repository;
    }

    /**
     * チャネルに対応する通知実装を生成します。
     *
     * @param channel 通知チャネル
     * @return 通知実装
     */
    public Notification create(NotificationChannel channel) {
        // チャネルごとに具象クラスを切り替える。
        return switch (channel) {
            case EMAIL -> new EmailNotification(repository);
            case SMS -> new SmsNotification(repository);
            case SLACK -> new SlackNotification(repository);
        };
    }
}
