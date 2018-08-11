#include <iostream>
#include <string>
#include <vector>
#include <filesystem>

namespace fs = std::filesystem;
using namespace std;

void print_backing(string_view subbed, bool dir, int len) {
  cout << '|';
  for(int i = 0; i < len; i++) {
    cout << "  |";
  }
  cout << "--";
  if(dir) {
    cout << "/";
  }
  cout << subbed << endl;
}

void print_dir(string dir, int len) {
  vector<string> execs;
  vector<string> hdirs;
  for(const auto &f : fs::directory_iterator(dir)) {
    string path = f.path();
    string subbed = fs::path(path).filename();
    if(fs::is_directory(path)) {
      if(subbed[0] != '.') {
         print_backing(subbed, true, len);
	 print_dir(path, len + 1);
      }else{
         hdirs.push_back(subbed);
      }
    } else {
      execs.push_back(subbed);
    }
  }
  for(const auto &hd : hdirs) {
    print_backing(hd + " (content hidden)", true, len);
  }
  for(const auto &e : execs) {
    print_backing(e, false, len);
  }
}

int main(int argc, char *argv[]) {
  string file;
  if (argc > 1) {
    file = argv[1];
    if(!fs::is_directory(file)) {
      cout << "Failed to find `" << file << "` as a valid directory." << endl;
      return 1;
    }
  } else {
    file = fs::current_path();
  }
  cout << file << endl;
  print_dir(file, 0);
  return 0;
}
