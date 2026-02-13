package com.example.notificationapp.notification;

import com.example.notificationapp.model.NotificationHistory;
import com.example.notificationapp.model.NotificationRequest;

/**
 * 通知処理を表すインターフェース。
 */
public interface Notification {
    /**
     * 通知を送信します。
     * 副作用として送信ログ出力や履歴保存が発生する場合があります。
     *
     * @param request 通知リクエスト
     * @return 送信履歴
     */
    NotificationHistory send(NotificationRequest request);
}
