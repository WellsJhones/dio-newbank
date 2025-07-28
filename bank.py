saldo = 0
movimentacoes = []


def adicionar_movimentacao(valor):
    global saldo
    saldo += valor
    movimentacoes.append(valor)


def obter_saldo():
    return saldo


def obter_historico():
    return movimentacoes


print("Bem-vindo ao sistema bancario!")


def main():

    movimentacao = input(
        "operacoes permitidas: depositar, retirar, extrato e sair \n")
    if movimentacao.lower() == 'sair':
        print("Encerrando o programa.")
        exit()
    elif movimentacao.lower() == 'depositar':
        valor = float(input("Digite o valor a depositar: \n"))
        adicionar_movimentacao(valor)
        print(f"Depósito de {valor} realizado. \n")
    elif movimentacao.lower() == 'retirar':
        valor = float(input("Digite o valor a retirar: \n"))
        if valor > obter_saldo():
            print("Saldo insuficiente para retirada.\n")
        else:
            adicionar_movimentacao(-valor)
            print(f"Retirada de {valor} realizada. \n")
    elif movimentacao.lower() == 'extrato':
        print("Extrato:")
        for i, valor in enumerate(obter_historico(), 1):
            tipo = "Depósito" if valor > 0 else "Retirada"
            print(f"{i}. {tipo}: {valor}")
    else:
        print("Operação inválida. Tente novamente.\n")
    print("Saldo:", obter_saldo())
    print("Histórico de movimentações:", obter_historico())


while True:
    main()
