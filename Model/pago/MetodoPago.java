package pago;

import java.io.*;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;

public abstract class MetodoPago{

    public MetodoPago() {
    }

    public abstract boolean procesarPago(double monto);

}