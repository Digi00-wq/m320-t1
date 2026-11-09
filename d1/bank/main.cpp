#include <cstdint>
#include <iostream>
#include <ostream>
#include <string>
#include <vector>

class MoneyHolder {
  private:
    double money_;
    uint64_t id_;

  public:
    MoneyHolder(double _money) : money_(_money) {
        static uint64_t id_ctr = 0;
        id_ = id_ctr++;
    }

    bool receive(MoneyHolder& sender, double n) {
        std::cout << "Transfer from " << sender.id_ << " To " << id_ << std::endl;

        if (sender.money_ < n) {
            std::cout << "Sender does not have enough money!" << std::endl;
            return false;
        }

        if (&sender == this) {
            std::cout << "Sender is equal to recipient!" << std::endl;
            return false;
        }

        money_ += n;
        sender.money_ -= n;

        std::cout << "Transaction successful!" << std::endl;

        return true;
    }

    double get_money() { return money_; }
    double get_id() { return id_; }
};

class Person : public MoneyHolder {
  public:
    Person(double _money, std::string_view _first_name, std::string_view _last_name)
        : MoneyHolder(_money), first_name(_first_name), last_name(_last_name) {}

    std::string first_name;
    std::string last_name;
};

class BankAccount : public MoneyHolder {
  public:
    BankAccount(double _money, std::string_view _bank_name)
        : MoneyHolder(_money), bank_name(_bank_name) {}

    std::string bank_name;
};

int main() {
    std::cout << "Welcome to OOP Bank" << std::endl;

    Person p(100, "Linus", "Torvalds");

    BankAccount ba1(50, "Raiffeisein");
    BankAccount ba2(100, "ZKB");

    std::vector<MoneyHolder*> money_holders = {&p, &ba1, &ba2};

    while (true) {
        std::cout << p.first_name << ' ' << p.last_name << " Has " << p.get_money() << "$"
                  << " and has ID " << p.get_id() << std::endl;
        std::cout << "Bank account from " << ba1.bank_name << " Has " << ba1.get_money() << "$"
                  << " and has ID " << ba1.get_id() << std::endl;
        std::cout << "Bank account from " << ba2.bank_name << " Has " << ba2.get_money() << "$"
                  << " and has ID " << ba2.get_id() << std::endl;

        std::cout << "Enter ID of transfer recipient:" << std::endl;

        int recipient_id;
        std::cin >> recipient_id;

        std::cout << "Enter ID of transer sender:" << std::endl;

        int sender_id;
        std::cin >> sender_id;

        std::cout << "Enter amount of money to transfer:" << std::endl;

        double money;
        std::cin >> money;

        MoneyHolder* recipient = nullptr;
        MoneyHolder* sender = nullptr;

        for (MoneyHolder* mh : money_holders) {
            if (mh->get_id() == recipient_id)
                recipient = mh;
            else if (mh->get_id() == sender_id)
                sender = mh;
        }

        if (!recipient) {
            std::cout << "Recipient does not exist" << std::endl;
            continue;
        }
        if (!sender) {
            std::cout << "Sender does not exist" << std::endl;
            continue;
        }

        recipient->receive(*sender, money);

        std::cout << std::endl;
    }

    return 0;
}
