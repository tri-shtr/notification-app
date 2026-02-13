package com.example.notificationapp.model;

/**
 * 通知送信のリクエスト情報を保持するモデル。
 */
public class NotificationRequest {
    private final NotificationChannel channel;
    private final Recipient recipient;
    private final String message;

    /**
     * 通知リクエストを生成します。
     * 必須項目が未指定の場合は {@link IllegalArgumentException} を送出します。
     *
     * @param channel 通知チャネル
     * @param recipient 受信者
     * @param message 送信メッセージ
     * @throws IllegalArgumentException いずれかが {@code null} の場合
     */
    public NotificationRequest(NotificationChannel channel, Recipient recipient, String message) {
        // 必須項目のバリデーションを行う。
        if (channel == null) {
            throw new IllegalArgumentException("Notification channel is required");
        }
        if (recipient == null) {
            throw new IllegalArgumentException("Recipient is required");
        }
        if (message == null) {
            throw new IllegalArgumentException("Message is required");
        }
        this.channel = channel;
        this.recipient = recipient;
        this.message = message;
    }

    /**
     * 通知チャネルを返します。
     *
     * @return 通知チャネル
     */
    public NotificationChannel getChannel() {
        return channel;
    }

    /**
     * 受信者を返します。
     *
     * @return 受信者
     */
    public Recipient getRecipient() {
        return recipient;
    }

    /**
     * 送信メッセージを返します。
     *
     * @return 送信メッセージ
     */
    public String getMessage() {
        return message;
    }
}
