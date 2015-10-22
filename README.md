# CLIENT Sample

https://github.com/backpaper0/simple-api-sample のクライアントさんです。

## 設定

通信先のサーバーと、このクライアントで使用するアカウントの設定です。
`application.yml` に書いてるので、必要に応じて上書きしてね。

* `sample.api.url`
  * サーバーのURLになります。
  * サーバーをローカルでそのまま起動した場合は変更いらないです。
* `sample.userId`
  * ツイートに使用されるユーザーIDです。
  * 設定した値はサーバーで登録してやってください。
  * 登録されていないユーザーIDで投稿しても、しれっと無視されます。

## 動かし方

```
gradlew bootRun
```

サーバーを起動させてから、以下のアドレスを開いてください。

Browse http://localhost:8090

タイムライン表示も投稿も全部この画面です。
投稿はユーザーID固定です。 `sample.userId` のユーザーをサーバー側で登録してやってください。

## メモ

この子は `${sample.api.url}/timeline` を表示するのが主な仕事です。
結果は以下の形で返ってくることを想定しています。

```
{"tweets":[{"id":"xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx","text":"ついーとだよー","timestamp":"2015-10-20T12:34:56.789","userId":"xxxxxxx"}, ...]}
```

レスポンスは `Timeline<Tweet>` にマッピングします。
コードを単純にするために、クラス名/フィールド名とjsonやhtmlを直接あてていますので、変更するときは一緒にしなきゃです。
