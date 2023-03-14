package com.rapidexTransportadoraAPI.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PedidoDeEntrega {
    Long idPedido;
    BigDecimal taxa;
    LocalDateTime dataDoPedido;
    LocalDateTime dataDeFinalizacao;
    Cliente cliente;
    Destinatario destinatario;
}
