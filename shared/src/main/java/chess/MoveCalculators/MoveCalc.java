package chess.MoveCalculators;

import chess.ChessBoard;
import chess.ChessGame;
import chess.ChessMove;
import chess.ChessPosition;

import java.util.HashSet;

public class MoveCalc {

    static boolean isValid(ChessPosition position){
        return (position.getRow() >= 1 && position.getRow() <= 8) &&
                (position.getColumn() >= 1 && position.getColumn() <= 8);
    }


    static HashSet<ChessMove> directionalMovement(ChessBoard board, ChessPosition position, int[][] possibleMoves,
                                                  int yPos, int xPos, ChessGame.TeamColor teamColor){
        HashSet<ChessMove> moves = new HashSet<>();
        for(int[] direction:possibleMoves){
            boolean blocked = false;
            int i = 1;
            while(!blocked){
                ChessPosition newPosition = new ChessPosition(yPos + direction[1] * i, xPos + direction[0] * i);

                if(!isValid(newPosition)){
                    blocked = true;
                }
                else if(board.getPiece(newPosition) == null){
                    moves.add(new ChessMove(position, newPosition, null));
                }
                else if(board.getPiece(newPosition).getTeamColor() != teamColor){
                    moves.add(new ChessMove(position, newPosition, null));
                    blocked = true;
                }
                else if(board.getPiece(newPosition).getTeamColor() == teamColor){
                    blocked = true;
                }
                i++;
            }
        }
        return moves;
    }

    static HashSet<ChessMove> singleMovement(ChessBoard board, ChessPosition position, int[][] possibleMoves,
                                                  int yPos, int xPos, ChessGame.TeamColor teamColor){
        HashSet<ChessMove> moves = new HashSet<>();
        for(int[] direction:possibleMoves){
            ChessPosition newPosition = new ChessPosition(yPos + direction[1], xPos + direction[0]);
            if(isValid(newPosition)){
                if(board.getPiece(newPosition) == null){
                    moves.add(new ChessMove(position, newPosition, null));
                }
                else if(board.getPiece(newPosition).getTeamColor() != teamColor){
                    moves.add(new ChessMove(position, newPosition, null));
                }
            }
        }
        return moves;
    }
}
