import {Entity, PrimaryGeneratedColumn, Column, ManyToOne, JoinColumn, OneToMany} from "typeorm";
import { Questions } from "./Questions";
import { Users } from "./Users";


@Entity()
export class Answers {

    @PrimaryGeneratedColumn()
    id: number;

    @Column()
    text: string;

    @ManyToOne(type => Questions, questions => questions.answers)
    @JoinColumn({name: "question_id"})
    questions: Questions;

    @ManyToOne(type => Users, users => users.answers)
    @JoinColumn({name: "user_id"})
    users: Users[]



}