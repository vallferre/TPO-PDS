import pedido.Pedido;
import producto.CategoriaProducto;
import producto.Producto;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Producto 1: Entrada
        Producto empanada = new Producto(
                1,
                "Empanada de carne",
                "Empanada criolla con carne picada, cebolla y huevo",
                500.0f,
                List.of("Gluten", "Huevo"),
                CategoriaProducto.ENTRADA
        );

        // Producto 2: Plato principal
        Producto milanesa = new Producto(
                2,
                "Milanesa con papas",
                "Milanesa de carne con papas fritas caseras",
                1800.0f,
                List.of("Gluten", "Huevo"),
                CategoriaProducto.PLATO_PRINCIPAL
        );

        // Producto 3: Postre
        Producto helado = new Producto(
                3,
                "Helado de chocolate",
                "Helado artesanal de chocolate con almendras",
                700.0f,
                List.of("Lácteos", "Frutos secos"),
                CategoriaProducto.POSTRE
        );

// Producto 4: Bebida
        Producto limonada = new Producto(
                4,
                "Limonada casera",
                "Limonada natural con menta y jengibre",
                450.0f,
                List.of(), // sin alérgenos
                CategoriaProducto.BEBIDA
        );

// Producto 5: Plato vegetariano
        Producto ensalada = new Producto(
                5,
                "Ensalada César veggie",
                "Lechuga, croutons, aderezo César sin anchoas, queso",
                1200.0f,
                List.of("Gluten", "Lácteos"),
                CategoriaProducto.PLATO_PRINCIPAL
        );

    }
}
