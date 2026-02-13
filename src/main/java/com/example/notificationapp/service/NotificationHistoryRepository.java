package com.example.notificationapp.service;

import com.example.notificationapp.model.NotificationHistory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 通知履歴を保持する簡易リポジトリ。
 * インメモリのため永続化はされず、スレッドセーフではありません。
 */
public class NotificationHistoryRepository {
    private final List<NotificationHistory> histories = new ArrayList<>();

    /**
     * 履歴を保存します。
     *
     * @param history 保存する履歴
     */
    public void save(NotificationHistory history) {
        histories.add(history);
    }

    /**
     * すべての履歴を取得します。
     *
     * @return 変更不可の履歴一覧
     */
    public List<NotificationHistory> findAll() {
        return Collections.unmodifiableList(histories);
    }
}
