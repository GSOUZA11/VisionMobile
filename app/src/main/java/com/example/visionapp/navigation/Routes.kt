package com.example.visionapp.navigation

object Routes {

    const val SPLASH = "splash"

    const val LOGIN = "login"
    const val CADASTRO = "cadastro"
    const val ESQUECEU_SENHA = "esqueceu_senha"

    const val HOME = "home"

    const val CATEGORIA = "categoria"
    const val CARRINHO = "carrinho"
    const val MAIS = "mais"

    const val PERFIL = "perfil"
    const val EDITAR_PERFIL = "editar_perfil"

    const val PRODUTOS_CATEGORIA =
        "produtos_categoria/{categoria}"

    const val MINHAS_COMPRAS = "minhas_compras"

    const val FAVORITOS = "favoritos"

    const val CHECKOUT = "checkout"

    const val PAGAMENTO = "pagamento"

    const val NOTIFICACOES = "notificacoes"

    const val CONFIGURACOES = "configuracoes"

    const val FALE_CONOSCO = "fale_conosco"

    const val SOBRE_NOS = "sobre_nos"

    fun produtosCategoria(
        categoria: String
    ) = "produtos_categoria/$categoria"
}