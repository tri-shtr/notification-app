package com.example.notificationapp.service;

import com.example.notificationapp.model.NotificationHistory;
import com.example.notificationapp.model.NotificationRequest;
import com.example.notificationapp.notification.Notification;

/**
 * 通知送信のユースケースを提供するサービス。
 */
public class NotificationService {
    private final NotificationFactory factory;

    /**
     * サービスを生成します。
     *
     * @param factory 通知ファクトリ
     */
    public NotificationService(NotificationFactory factory) {
        this.factory = factory;
    }

    /**
     * 通知を送信します。
     * 副作用として送信ログ出力と履歴保存が行われる場合があります。
     *
     * @param request 通知リクエスト
     * @return 送信履歴
     */
    public NotificationHistory send(NotificationRequest request) {
        // チャネルに応じた通知実装を取得して送信する。
        Notification notification = factory.create(request.getChannel());
        return notification.send(request);
    }
}
