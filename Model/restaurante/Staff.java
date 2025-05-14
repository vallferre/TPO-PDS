package restaurante;

import java.io.*;
import java.util.*;
import pedido.Estado;
import pedido.Pedido;

public abstract class Staff {


    public Staff() {
    }

    public abstract void actualizarEstado(Estado estado);

}