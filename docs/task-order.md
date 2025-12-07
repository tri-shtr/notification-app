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
インタフェースを作成

### EmailRecipient

- コンストラクタでメール形式チェック（@ を含む等の簡易チェックで可）。不正な値のとき IllegalArgumentException を投げる。
- asString() はメールアドレスを返す。

### SmsRecipient

- コンストラクタで電話番号形式チェック（数字のみ、長さチェック等の簡易版）。不正な値のとき IllegalArgumentException を投げる。
- asString()は電話番号を返す。

### AppUserRecipient

- コンストラクタでアプリ内ユーザーID（文字列）の簡易チェック（空でない等）。不正な値のとき IllegalArgumentException を投げる。
- asString()はユーザーIDを返す。

## 1-4. NotificationRequest（エンティティ）
- channel（NotificationChannel）
- to（ContactInfo）
- message（String）
- コンストラクタで不正値チェック

## 1-5. NotificationHistory（エンティティ）
- リクエスト + 結果 + タイムスタンプを保持

---

# ⚙️ Step 2 — バリデーション層の実装

## 2-1. NotificationValidator（interface）
- `boolean isValid(ContactInfo info)` を定義

## 2-2. EmailValidator  
## 2-3. SmsValidator  
## 2-4. SlackValidator  
- 各チャネル固有のバリデーションを実装

---

# 🔌 Step 3 — サービス層の実装（ポリモーフィズムの中心）

## 3-1 NotificationService（interface）
- `NotificationHistory send(NotificationRequest request)` を定義

## 3-2 EmailNotificationService  
## 3-3 SmsNotificationService  
## 3-4 SlackNotificationService  
- チャネルごとに異なる送信処理を実装  
- Validator を内部で使用

---

# 🏭 Step 4 — ファクトリ層の実装

## 4-1 NotificationServiceFactory
- NotificationChannel に応じて  
  **適切な NotificationService インスタンスを返す**

Spring Framework の DI と親和性が高い実装ポイント。

---

# ▶️ Step 5 — Main クラスを完成させる

- NotificationRequest を複数生成
- Factory から Service を取得
- send() を呼び、結果を標準出力へ表示

---

# 📝 Step 6 — 動作確認

- `mvn compile exec:java` で実行
- すべてのチャネルで期待通りの結果が出力されることを確認

---

# 📘 以上で課題は完了です。お疲れさまでした！