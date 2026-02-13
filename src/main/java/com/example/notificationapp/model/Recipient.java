package com.example.notificationapp.model;

/**
 * 受信者の共通モデル。
 * 値は不変で、スレッドセーフです。
 */
public abstract class Recipient {
    private final String value;

    /**
     * 受信者を生成します。
     *
     * @param value 受信者の識別子
     */
    protected Recipient(String value) {
        this.value = value;
    }

    /**
     * 文字列表現を返します。
     *
     * @return 受信者の識別子
     */
    public String asString() {
        return value;
    }

    /**
     * 文字列表現を返します。
     *
     * @return 受信者の識別子
     */
    @Override
    public String toString() {
        return value;
    }
}
