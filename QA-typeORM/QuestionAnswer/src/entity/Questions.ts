import {Entity, PrimaryGeneratedColumn, Column, OneToMany, ManyToOne, JoinColumn} from "typeorm";
import { Answers } from "./Answers";
import { Users } from "./Users";

@Entity()
export class Questions {

    @PrimaryGeneratedColumn()
    id: number;

    @Column()
    description: string;

    @ManyToOne(type => Users, users => users.questions)
    @JoinColumn({name: "user_id"})
    users: Users[]

    @OneToMany(type => Answers, answers => answers.questions)
    answers: Answers[]

}
