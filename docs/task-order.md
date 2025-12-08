# 課題実施順序 – Notification App（Polymorphism Training）

このドキュメントでは、学習者が迷わず課題を実施できるよう  
**1 クラスずつ順番に実装するステップ** をまとめています。

---

# 🔰 Step 0 — プロジェクト準備

1. Maven プロジェクトを作成  
2. `com.example.notificationapp` をルートパッケージとして作成  
3. `model`, `service`, `notification` の各サブパッケージを作成  
4. `Main` クラスを空で配置

---

# 🧱 Step 1 — モデル層の基礎実装

## 1-1. NotificationChannel（enum）
- EMAIL / SMS / SLACK の 3 つを定義

## 1-2. NotificationStatus（enum）
- SUCCESS / FAILURE を定義

## 1-3. Recipient

### EmailRecipient

- コンストラクタでメール形式チェック（@ を含む等の簡易チェックで可）。不正な値のとき IllegalArgumentException を投げる。
- asString() はメールアドレスを返す。

### SmsRecipient

- コンストラクタで電話番号形式チェック（数字のみ、長さチェック等の簡易版）。不正な値のとき IllegalArgumentException を投げる。
- asString()は電話番号を返す。

### SlackRecipient

- コンストラクタでSlackユーザーID（文字列）の簡易チェック（空でない等）。不正な値のとき IllegalArgumentException を投げる。
- asString()はユーザーIDを返す。

## 1-4. NotificationRequest（エンティティ）

## 1-5. NotificationHistory（エンティティ）

---

# 🔌 Step 3 — 通知処理（notificationパッケージ）の実装

## 3-1 Notification インタフェース

## 3-2 AbstractNotification
- 通知履歴を登録する `createHistory()` を実装する。

## 3-2 EmailNotification
- メール送信処理を実装
- 本課題ではダミー実装として、下記の文字列を出力
  ```text
  [Email] Sent to user@example.com: "Hello!"
  ```
- 通知履歴を登録する。

## 3-3 SmsNotification
- SMSへの送信処理を実装
- 本課題ではダミー実装として、下記の文字列を出力
  ```text
  [SMS] Sent to 09012345678: "Hello!"
  ```
- 通知履歴を登録する。

## 3-4 SlackNotification
- Slackへの送信処理を実装
- 本課題ではダミー実装として、下記の文字列を出力
  ```text
  [Slack] Sent to U000999: "Hello!"
  ```
- 通知履歴を登録する。

---

# 🏭 Step 4 — ファクトリ層の実装

## 4-1 NotificationFactory
- NotificationChannel に応じて**適切な Notification インスタンスを返す**

Spring Framework の DI と親和性が高い実装ポイント。

---

# 🔌 Step 3 — サービス層の実装（ポリモーフィズムの中心）

## 3-1 NotificationService
- `NotificationHistory send(NotificationRequest request)` を定義

---

# ▶️ Step 5 — Main クラスを完成させる

- NotificationRequest を生成
- NotificationService.send() を呼び、結果を標準出力へ表示

---

# 📝 Step 6 — 動作確認

- `mvn compile exec:java` で実行
- すべてのチャネルで期待通りの結果が出力されることを確認

---

# 📘 以上で課題は完了です。お疲れさまでした！