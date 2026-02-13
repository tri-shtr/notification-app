package com.example.notificationapp.notification;

import com.example.notificationapp.model.NotificationHistory;
import com.example.notificationapp.model.NotificationRequest;
import com.example.notificationapp.model.NotificationStatus;
import com.example.notificationapp.service.NotificationHistoryRepository;

/**
 * SMS通知の実装。
 * 副作用として標準出力へ送信ログを出力します。
 */
public class SmsNotification extends AbstractNotification {
    /**
     * SMS通知を生成します。
     *
     * @param repository 履歴リポジトリ
     */
    public SmsNotification(NotificationHistoryRepository repository) {
        super(repository);
    }

    /**
     * SMS通知を送信します。
     * 副作用として標準出力へのログ出力と履歴保存が行われます。
     *
     * @param request 通知リクエスト
     * @return 送信履歴
     */
    @Override
    public NotificationHistory send(NotificationRequest request) {
        System.out.println("[SMS] Sent to " + request.getRecipient().asString()
                + ": \"" + request.getMessage() + "\"");
        return createHistory(request, NotificationStatus.SUCCESS);
    }
}
