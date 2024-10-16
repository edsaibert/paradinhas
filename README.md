# paradinhas
Jogo tipo Monopoly para a disciplina de Paradigmas da Programação


### Dependências
- JavaFX: necessário que os conteúdos do diretório lib da versão 21.0.5 (para JDK >= 17) sejam incorporados ao diretório javafx do diretório lib do projeto atual - para fins de compilação e dependencias.
```bash
cd ~
wget https://download2.gluonhq.com/openjfx/21.0.5/openjfx-21.0.5_linux-x64_bin-sdk.zip
unzip openjfx-21.0.5_linux-x64_bin-sdk.zip && rm -rf openjfx-21.0.5_linux-x64_bin-sdk.zip
mv ~/openjfx-21.0.5_linux-x64_bin-sdk/lib ./lib/javafx
rm -rf ~/openjfx-21.0.5_linux-x64_bin-sdk
```