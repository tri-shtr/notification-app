package com.example.notificationapp;

import com.example.notificationapp.model.EmailAddress;
import com.example.notificationapp.model.NotificationChannel;
import com.example.notificationapp.model.NotificationHistory;
import com.example.notificationapp.model.NotificationRequest;
import com.example.notificationapp.model.PhoneNumber;
import com.example.notificationapp.model.SlackUserID;
import com.example.notificationapp.service.NotificationFactory;
import com.example.notificationapp.service.NotificationHistoryRepository;
import com.example.notificationapp.service.NotificationService;

import java.util.List;

/**
 * 通知アプリのエントリーポイント。
 * 各チャネルへの送信と履歴の表示をデモします。
 * 副作用として標準出力へログを出力します。
 */
public class Main {
    /**
     * サンプル処理を実行します。
     * 副作用として通知送信のログと履歴を標準出力へ表示します。
     *
     * @param args コマンドライン引数（未使用）
     */
    public static void main(String[] args) {
        System.out.println("=== Start Notification App ===");

        NotificationHistoryRepository repository = new NotificationHistoryRepository();
        NotificationFactory factory = new NotificationFactory(repository);
        NotificationService service = new NotificationService(factory);

        // 送信リクエストをチャネルごとに用意する。
        NotificationRequest emailRequest = new NotificationRequest(
                NotificationChannel.EMAIL,
                new EmailAddress("user@example.com"),
                "Hello!"
        );
        NotificationRequest smsRequest = new NotificationRequest(
                NotificationChannel.SMS,
                new PhoneNumber("09012345678"),
                "Hello!"
        );
        NotificationRequest slackRequest = new NotificationRequest(
                NotificationChannel.SLACK,
                new SlackUserID("U000999"),
                "Hello!"
        );

        service.send(emailRequest);
        service.send(smsRequest);
        service.send(slackRequest);

        System.out.println();
        System.out.println("*** Notification History");
        List<NotificationHistory> histories = repository.findAll();
        for (NotificationHistory history : histories) {
            System.out.println(history.toDisplayString());
        }

        System.out.println("=== End Notification App ===");
    }
}
