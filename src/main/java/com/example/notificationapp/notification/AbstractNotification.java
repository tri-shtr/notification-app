package com.example.notificationapp.notification;

import com.example.notificationapp.model.NotificationHistory;
import com.example.notificationapp.model.NotificationRequest;
import com.example.notificationapp.model.NotificationStatus;
import com.example.notificationapp.service.NotificationHistoryRepository;

import java.time.LocalDateTime;

/**
 * 通知処理の共通ロジックを提供する抽象クラス。
 */
public abstract class AbstractNotification implements Notification {
    private final NotificationHistoryRepository repository;

    /**
     * 履歴保存先を指定して生成します。
     *
     * @param repository 履歴リポジトリ
     */
    protected AbstractNotification(NotificationHistoryRepository repository) {
        this.repository = repository;
    }

    /**
     * 送信履歴を生成し保存します。
     *
     * @param request 通知リクエスト
     * @param status 送信結果
     * @return 作成した履歴
     */
    protected NotificationHistory createHistory(NotificationRequest request, NotificationStatus status) {
        NotificationHistory history = new NotificationHistory(
                LocalDateTime.now(),
                request.getChannel(),
                request.getRecipient(),
                request.getMessage(),
                status
        );
        // 履歴はこのタイミングで保存する。
        repository.save(history);
        return history;
    }
}
