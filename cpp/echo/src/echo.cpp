#include <iostream>

using namespace std;

int main(int argc, char* argv[]) {
  for(int i = 1; i < argc; i++) {
    cout << argv[i];
    if(i + 1 < argc) {
      cout << " ";
    }
  }
  cout << endl;
  return 0;
}
