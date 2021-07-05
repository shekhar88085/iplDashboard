import{React,useEffect,useState} from 'react';
import { MatchSmallCard } from '../components/MatchSmallCard';
import { MatchDetailCard } from '../components/MatchDetailCard';

export const TeamPage=() =>{

const[team,setTeam]=useState({matches:[]});

 useEffect(
        () => {
         const fetchMatches = async () => {
            const response = await fetch('http://localhost:8085/team/Rajasthan Royals');
            const data = await response.json();
            //console.log(data);
            setTeam(data);

         };
         fetchMatches();



        }, []
    );

  return (
    <div className="TeamPage">
<h1>{team.teamName}</h1>



	  <MatchDetailCard match={team.matches[0]} />
    {team.matches.map(match=><MatchSmallCard  match={match} />)}
	 

    </div>
  );
}

//export default TeamPage;















