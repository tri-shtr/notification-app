package com.example.notificationapp.model;

/**
 * SlackのユーザーIDを表す受信者モデル。
 */
public class SlackUserID extends Recipient {
    /**
     * SlackユーザーIDを生成します。
     * 不正な場合は {@link IllegalArgumentException} を送出します。
     *
     * @param value ユーザーID文字列
     * @throws IllegalArgumentException 値が空の場合
     */
    public SlackUserID(String value) {
        super(validate(value));
    }

    /**
     * SlackユーザーIDの簡易バリデーションを行います。
     *
     * @param value 入力値
     * @return 正常なユーザーID
     */
    private static String validate(String value) {
        // 空/NULLのみを排除する。
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Slack user ID is blank");
        }
        return value;
    }
}
