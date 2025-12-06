# Notification App – Java Polymorphism Training

このリポジトリは、新人 Java プログラマー向けに「ポリモーフィズム（多態性）」を中心としたオブジェクト指向の基礎を実践的に学ぶための課題です。

企業の情報システムにも登場しやすい「通知処理（メール・SMS・Slack 等）」を題材とし、  
ビジネスロジックをどのようにオブジェクト指向で構築するかを段階的に学びます。

---

## 📌 1. プロジェクト概要

### ■ 目的
- ポリモーフィズムの理解と実装
- インターフェースと実装クラスの役割理解
- 値オブジェクトの設計を体験
- ビジネスロジックの分離・階層化
- 次ステップ（Spring Framework の DI）につながる設計思想を習得

### ■ 機能概要
本アプリケーションはユーザーが通知リクエストを作成し、  
通知チャネル（Email、SMS、Slack）に応じて適切なサービスが処理を実行します。

処理結果は **NotificationHistory** として保持され、  
成功・失敗の履歴が標準出力に表示されます。

### ■ クラス図

### ■ シーケンス図

---

## 📁 2. ディレクトリ構造
```
src/
└─ main/
├─ java/com/example/notificationapp/
│ ├─ model/
│ ├─ service/
│ ├─ factory/
│ ├─ validator/
│ └─ Main.java
└─ resources/
pom.xml
README.md
docs/
└─ task-order.md
```


---

## ▶️ 3. 実行方法

### ■ 前提
- Java 17 以上
- Maven 3.8+  
  （`mvn -v` で確認）

### ■ 実行手順

#### 1. 依存ダウンロード & コンパイル

```shell
mvn clean compile
```

#### 2. 実行
```shell
mvn exec:java -Dexec.mainClass="com.example.notificationapp.Main"
```
または、JAR を作成して実行する場合：
```shell
mvn package
java -jar target/notificationapp-1.0.0-SNAPSHOT.jar
```

---

## 📡 4. API 仕様（モデル仕様）

### NotificationRequest
| フィールド | 型 | 説明 |
|-----------|----|------|
| channel | NotificationChannel | 通知チャネル（EMAIL, SMS, SLACK）|
| to | ContactInfo | 値オブジェクト（メール、電話番号などを格納） |
| message | String | 送信したいメッセージ |

---

### NotificationHistory
| フィールド | 型 | 説明 |
|-----------|----|------|
| request | NotificationRequest | 元リクエスト |
| status | NotificationStatus | 成否（SUCCESS / FAILURE） |
| timestamp | LocalDateTime | 実行時刻 |
| errorMessage | String | エラー時のメッセージ |

---

## 🔌 5. 実装される通知チャネル

### 1. EmailNotificationService
- メールアドレスをバリデーション
- 実行成功時は「メール送信」と出力（実際の送信は行わない）

### 2. SmsNotificationService
- 電話番号をバリデーション
- 成功時に「SMS送信」と出力

### 3. SlackNotificationService
- Slack用ユーザー ID をチェック
- 成功時に「Slack送信」と出力

---

## 🧪 6. 動作例（標準出力）
```
=== Notification App ===
[Email] Sent to user@example.com
: "Hello!"
[SMS] Sent to 09012345678: "Hello!"
[Slack] Sent to U000999: "Hello!"
```

---

## 🚀 7. 拡張案（課題提出後に実施可能）

### 機能拡張
- Push / LINE / Teams などのチャネル追加
- NotificationHistory をファイルまたは DB に保存
- リクエストを JSON 化して入力データとして使う

### アプリケーションレベルの拡張
- Loggers を導入し、標準出力からログファイル出力へ
- JSON 入力で NotificationRequest を作成する（Jackson など導入）
- Retry 機能の追加（失敗時に 3 回まで再送）

### OOP の深化
- チャネル追加をもっと柔軟にする  
  → Factory の差し替え + Strategy パターン強化
- Validator の共通部分を抽象クラス化

### Spring Framework への接続
- NotificationService の生成を DI コンテナに任せる  
- Factory → @Configuration / @Bean に置き換え  
- Service を @Service アノテーションで管理

---

## 📄 8. 課題手順

課題を実施する順番は
docs/task-order.md を参照してください。

---

## 📘 9. ライセンス

MIT License