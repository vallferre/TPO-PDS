import cliente.Cliente;
import cliente.CuponDescuento;
import cliente.Email;
import notificacion.INotificable;
import notificacion.NotificacionEmail;
import notificacion.NotificacionPush;
import pago.MetodoPago;
import pago.TarjetaCredito;
import pago.TarjetaDebito;
import pedido.Pedido;
import pedido.Pendiente;
import producto.CategoriaProducto;
import producto.IProducto;
import producto.Producto;
import restaurante.Menu;
import restaurante.Mozo;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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

        Menu menu = new Menu();

        menu.agregarProducto(empanada);
        menu.agregarProducto(milanesa);
        menu.agregarProducto(helado);
        menu.agregarProducto(limonada);
        menu.agregarProducto(ensalada);

        System.out.println("Productos del menú:");
        for (IProducto p : menu.getListaProductos()) {
            System.out.println(p.getNombre() + " - $" + p.getPrecio());
        }

        System.out.println("-----------------------------------");

        Email email = new Email("franco", "@gmail.com");
        INotificable canalEmail = new NotificacionEmail(email);
        Cliente cliente = new Cliente("Franco Lovera", email, canalEmail);

        INotificable notificacionPush = new NotificacionPush();
        Mozo mozo = new Mozo(notificacionPush);

        List<IProducto> productosSeleccionados = List.of(empanada, limonada);

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("MM/yy");
        YearMonth vencimiento = YearMonth.parse("12/26", formato);
        MetodoPago tarjeta = new TarjetaCredito("1234-5678-9876-5432", "Franco Lovera", "Av. Lima 757", vencimiento, 123);

        CuponDescuento cupon = new CuponDescuento("DESCUENTO10", 10, new Date()); // descuento del 10%

        Pedido pedido = new Pedido(
                new Pendiente(),                    // Estado inicial
                tarjeta,                            // método de pago
                productosSeleccionados,            // productos
                cupon,                               // cupón aplicable
                cliente
        );

        System.out.println("-----------------------------------");

        mozo.asignarPedido(pedido);

        System.out.println("-----------------------------------");

        Email email1 = new Email("ciro03", "@gmail.com");

        INotificable canalEmail1 = new NotificacionEmail(email1);

        DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("MM/yy");
        YearMonth vencimiento1 = YearMonth.parse("12/26", formato1);

        TarjetaDebito td = new TarjetaDebito("1223-5178-9556-5434", "Ciro Insaurralde", "Av. Lima 757", vencimiento1, 123, 1.0f);

        List<IProducto> productosSeleccionados1 = List.of(empanada, limonada);

        Cliente cliente1 = new Cliente("Insaurralde Ciro", email1, canalEmail1);

        Pedido pedido1 = new Pedido(
                new Pendiente(),                    // Estado inicial
                td,                            // método de pago
                productosSeleccionados1,            // productos
                null,                               // cupón aplicable
                cliente1
        );

        System.out.println("Cliente: " + cliente1.getNombre());
        System.out.println("Email: " + cliente1.getEmail());
        for (IProducto p : productosSeleccionados1) {
            System.out.println(p.getNombre() + " - $" + p.getPrecio());
        }

        System.out.println("-----------------------------------");

        mozo.asignarPedido(pedido1);
    }
}
