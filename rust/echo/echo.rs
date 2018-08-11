use std::env;

fn main() {
  let args: Vec<String> = env::args().collect();
  for i in 1..args.len() {
    print!("{}", args[i]);
    if i + 1 < args.len() {
      print!(" ");
    }
  }
  println!();
}
