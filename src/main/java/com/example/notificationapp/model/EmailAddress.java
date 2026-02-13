package com.example.notificationapp.model;

/**
 * メールアドレスを表す受信者モデル。
 */
public class EmailAddress extends Recipient {
    /**
     * メールアドレスを生成します。
     * 不正な場合は {@link IllegalArgumentException} を送出します。
     *
     * @param value メールアドレス文字列
     * @throws IllegalArgumentException 値が空、または「@」を含まない場合
     */
    public EmailAddress(String value) {
        super(validate(value));
    }

    /**
     * メールアドレスの簡易バリデーションを行います。
     *
     * @param value 入力値
     * @return 正常なメールアドレス
     */
    private static String validate(String value) {
        // 最低限のチェック（空/NULL と '@' の存在）。
        if (value == null || value.isBlank() || !value.contains("@")) {
            throw new IllegalArgumentException("Invalid email address: " + value);
        }
        return value;
    }
}
