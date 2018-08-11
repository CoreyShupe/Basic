import System.Environment

printPiece x = do
  let b = x ++ " "
  putStr b

main = do
  ns <- getArgs
  mapM_ printPiece ns
  putStr "\b\n"
