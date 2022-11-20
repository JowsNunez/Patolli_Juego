# ___Arquitectura de Software___

## __Juego Patolli__

### __Servidor__

construir 
 
```
   javac -d ./out -cp src src/mx/patolli/main/Main.java
```

```
 cd out
```
crear carpeta META-INF y dentro el archivo MANIFEST.MF 
con ola siguiente linea: __Main-Class: mx.patolli.main.Main__

```
jar cvf META-INF/MANIFEST.MF mx/patolli Servidor.jar
 
```
* ejecutar
  
 ```
   java -jar Servidor.jar
 ```

### __Cliente__

construir 
 

