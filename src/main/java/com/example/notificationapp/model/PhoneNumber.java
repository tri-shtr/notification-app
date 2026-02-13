package com.example.notificationapp.model;

/**
 * 電話番号を表す受信者モデル。
 */
public class PhoneNumber extends Recipient {
    /**
     * 電話番号を生成します。
     * 不正な場合は {@link IllegalArgumentException} を送出します。
     *
     * @param value 電話番号文字列
     * @throws IllegalArgumentException 値が空、または数字10〜15桁でない場合
     */
    public PhoneNumber(String value) {
        super(validate(value));
    }

    /**
     * 電話番号の簡易バリデーションを行います。
     *
     * @param value 入力値
     * @return 正常な電話番号
     */
    private static String validate(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Phone number is blank");
        }
        // 数字のみ、長さ10〜15桁であることを確認する。
        if (!value.matches("\\d{10,15}")) {
            throw new IllegalArgumentException("Invalid phone number: " + value);
        }
        return value;
    }
}
