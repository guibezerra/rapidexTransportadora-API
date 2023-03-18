DROP TABLE IF EXISTS `clientes`;

CREATE TABLE `clientes` (
    `id_cliente` INT NOT NULL AUTO_INCREMENT,
    `nome` varchar(40) NOT NULL,
    `cpf` varchar(11) NOT NULL,
    `email` varchar(50),
    `telefone` varchar(13) NOT NULL,

    PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;
