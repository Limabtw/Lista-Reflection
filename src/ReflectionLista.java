import java.lang.reflect.Method;

public class ReflectionLista {

    public static void main(String[] args) {

        try {
            // Obtém a classe ArrayList
            Class<?> classeLista = Class.forName("java.util.ArrayList");

            // Instancia a lista via Reflection
            Object lista = classeLista.getDeclaredConstructor().newInstance();

            // Obtém o método add(Object)
            Method add = classeLista.getMethod("add", Object.class);

            // Adiciona elementos usando Reflection
            add.invoke(lista, "Gustavo");
            add.invoke(lista, "Java");
            add.invoke(lista, "Reflection");
            add.invoke(lista, 2026);

            // Obtém os métodos necessários
            Method size = classeLista.getMethod("size");
            Method get = classeLista.getMethod("get", int.class);

            // Percorre a lista usando Reflection
            int quantidade = (int) size.invoke(lista);

            System.out.println("Elementos da lista:");

            for (int i = 0; i < quantidade; i++) {
                Object elemento = get.invoke(lista, i);
                System.out.println(elemento);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}