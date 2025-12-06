# 課題実施順序 – Notification App（Polymorphism Training）

このドキュメントでは、学習者が迷わず課題を実施できるよう  
**1 クラスずつ順番に実装するステップ** をまとめています。

---

# 🔰 Step 0 — プロジェクト準備

1. Maven プロジェクトを作成  
2. `com.example.notificationapp` をルートパッケージとして作成  
3. `model`, `service`, `factory`, `validator` の各サブパッケージを作成  
4. `Main` クラスを空で配置

---

# 🧱 Step 1 — モデル層の基礎実装

## 1-1. NotificationChannel（enum）
- EMAIL / SMS / SLACK の 3 つを定義

## 1-2. NotificationStatus（enum）
- SUCCESS / FAILURE を定義

## 1-3. ContactInfo（値オブジェクト）
- “メール or 電話番号 or Slack ID“ を一つの型で表現
- 不変オブジェクトとして実装

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

# 🎉 Step 7 — 任意課題（さらに学びたい人向け）

- Validator の共通抽象クラス化
- チャネル追加（Push、Line、Teams、Webhook など）
- Main クラスを CLI / JSON 入力に対応
- Factory の差し替え（抽象工場パターン）

---

# 📘 以上で課題は完了です。お疲れさまでした！