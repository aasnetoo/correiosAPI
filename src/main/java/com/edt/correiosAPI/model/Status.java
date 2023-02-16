package com.edt.correiosAPI.model;

public enum Status {
    NEED_SETUP,    // Precisa baixar o CSV dos Correios
    SETUP_RUNNING, // Esta baixando/salvando no banco
    READY; // serviço apto para ser consumido
}
