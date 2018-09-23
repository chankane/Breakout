# Breakout
Javaを使ってブロック崩しをつくってもらいます

## Description
以下の条件を満たしてください
- ブロックをすべて消したら，"Clear"と表示してアプリケーションを強制終了する
- ボールが下についてしまったら，"Game Over"と表示してアプリケーションを強制終了する
- ボールは画面内で反射する（当然ですね）
- ブロックはボールが当たると消え，ボールは反射する（当然ですね）
- バーはキーボードの矢印キーの→と←で操作できるようにする

条件を満たしさえすれば後は好き勝手やっちゃってくれてOkayです  
コードを見て，個人的にアドバイスします

## Install
```
cd C:\Users\自分のユーザ名\eclipse-workspace
git clone https://github.com/chankane/Breakout.git
```
1. 上記のコマンドを実行
1. eclipse 起動
1. Project Explorer を右クリック
1. import -> Existing Project into Workspace -> Select root directory -> browse.. -> Breakout を選択

## Requirement
eclipse では標準で JavaFX が使えない可能性が高いです．  
その場合は各自で設定してください  
[JavaでJavaFX使うには](https://web-dev.hatenablog.com/entry/eclipse/install-efxclipse)

## Other
成果物は自身の名前のブランチを作ってアップすること  
質問は issue を使うこと
