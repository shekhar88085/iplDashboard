import{React,useEffect} from 'react';
import { MatchSmallCard } from '../components/MatchSmallCard';
import { MatchDetailCard } from '../components/MatchDetailCard';

export const TeamPage=() =>{

 useEffect(
        () => {
         const fetchMatches = async () => {
            const response = await fetch('http://localhost:8085/team/Delhi%20Capitals');
            const data = await response.json();
            console.log(data);

         };
         fetchMatches();



        }, []
    );

  return (
    <div className="TeamPage">
      <h1>Rajasthan Royals</h1>

	  <MatchDetailCard/>
	  <MatchSmallCard/>
	  <MatchSmallCard/>
	  <MatchSmallCard/>

    </div>
  );
}

//export default TeamPage;
