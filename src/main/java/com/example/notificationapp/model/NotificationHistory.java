package com.example.notificationapp.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 通知送信の履歴情報を保持するモデル。
 */
public class NotificationHistory {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    private final LocalDateTime timestamp;
    private final NotificationChannel channel;
    private final Recipient recipient;
    private final String message;
    private final NotificationStatus status;

    /**
     * 履歴エントリを生成します。
     * 参照を保持するのみで、入力値の検証は行いません。
     *
     * @param timestamp 送信時刻
     * @param channel 通知チャネル
     * @param recipient 受信者
     * @param message 送信メッセージ
     * @param status 送信結果
     */
    public NotificationHistory(LocalDateTime timestamp,
                               NotificationChannel channel,
                               Recipient recipient,
                               String message,
                               NotificationStatus status) {
        this.timestamp = timestamp;
        this.channel = channel;
        this.recipient = recipient;
        this.message = message;
        this.status = status;
    }

    /**
     * 送信時刻を返します。
     *
     * @return 送信時刻
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
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

    /**
     * 送信結果を返します。
     *
     * @return 送信結果
     */
    public NotificationStatus getStatus() {
        return status;
    }

    /**
     * 表示用の文字列に整形します。
     *
     * @return 表示用文字列
     */
    public String toDisplayString() {
        return String.format("%s [%s] %s \"%s\"",
                timestamp.format(FORMATTER),
                channelLabel(channel),
                recipient.asString(),
                message);
    }

    /**
     * チャネル名を表示用ラベルに変換します。
     *
     * @param channel 通知チャネル
     * @return 表示用ラベル
     */
    private String channelLabel(NotificationChannel channel) {
        return switch (channel) {
            case EMAIL -> "Email";
            case SMS -> "SMS";
            case SLACK -> "Slack";
        };
    }
}
