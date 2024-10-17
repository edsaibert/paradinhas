# Binários
JAVAC=/usr/bin/javac
JAVA=/usr/bin/java
JAR=/usr/bin/jar

# Diretórios
SRC_DIR=src
LIB_DIR=lib
LIB_JAVAFX_DIR=$(LIB_DIR)/javafx
BINDIR=bin
JARDIR=jars

# Adicione qualquer classpath externo que você precise
USERCLASSPATH=.

# Criando classpath dinâmico
TMPCLASSPATH=$(USERCLASSPATH):$(realpath $(BINDIR))
ifneq (,$(wildcard $(LIB_JAVAFX_DIR)/*.jar))
    CLASSPATH=$(TMPCLASSPATH):$(subst $(space),:,$(foreach jar,$(wildcard $(LIB_JAVAFX_DIR)/*.jar),$(realpath $(jar))))
endif

# Flags de compilação (inclui os módulos do JavaFX)
JCFLAGS=-g -d $(BINDIR) --module-path $(LIB_JAVAFX_DIR) --add-modules javafx.controls -classpath "$(CLASSPATH)"
# Flags de execução (força o modo de renderização de software)
JFLAGS=-Dprism.order=sw --module-path $(LIB_JAVAFX_DIR) --add-modules javafx.controls -classpath "$(CLASSPATH)"

# Encontra todos os arquivos .java no SRC_DIR
JAVA_FILES=$(shell find $(SRC_DIR) -name "*.java")

# Substitui os arquivos .java por .class e coloca no BINDIR
CLASS_FILES=$(patsubst $(SRC_DIR)/%.java, $(BINDIR)/%.class, $(JAVA_FILES))

# Regra para compilar todos os arquivos .java
compile: $(CLASS_FILES)

# Regra para compilar cada arquivo .java individualmente
$(BINDIR)/%.class: $(SRC_DIR)/%.java
	@mkdir -p $(dir $@)
	$(JAVAC) $(JCFLAGS) $<

install:
	@echo "Baixando JavaFX..."
	@mkdir -p $(LIB_DIR)
	@wget -q --show-progress -O $(LIB_DIR)/openjfx-21.0.5.zip https://download2.gluonhq.com/openjfx/21.0.5/openjfx-21.0.5_linux-x64_bin-sdk.zip
	@unzip -q $(LIB_DIR)/openjfx-21.0.5.zip -d $(LIB_DIR)/
	@mv $(LIB_DIR)/javafx-sdk-21.0.5/lib $(LIB_JAVAFX_DIR)
	@-rm -rf $(LIB_DIR)/openjfx-21.0.5.zip $(LIB_DIR)/javafx-sdk-21.0.5
	@echo "JavaFX instalado com sucesso!"

# Regra para executar uma classe específica
run: compile
	@$(JAVA) $(JFLAGS) application.Main

# Criação do JAR
jar: compile
	@mkdir -p $(JARDIR)
	$(JAR) cfe $(JARDIR)/application.jar application.Main -C $(BINDIR) .

# Limpeza
clean:
	@-rm -rf $(BINDIR) $(JARDIR)

.PHONY: compile run jar clean